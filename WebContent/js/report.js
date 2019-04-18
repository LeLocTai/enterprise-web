let reportData = {};

const chartsEl = $('#charts')
const formEl = $('#input-form')

formEl.submit((e) => {
    e.preventDefault();

    $.get('report-data', $(e.target).serialize())
        .done((res) => {
            reportData = JSON.parse(res);
            console.log(reportData);
            createDOMNodes()
            createCharts()
        })
});
formEl.submit()

function getYearDisplayName(year) {
    let dn = year.startdate.substr(0, year.startdate.indexOf('-'));
    dn += " - ";
    dn += year.enddate.substr(0, year.enddate.indexOf('-'));

    return dn;
}

function createDOMNodes() {
    chartsEl.empty()
    for (let year of reportData.years) {
        let yearEl = $(`<div class="year-data" id="year-data-${year.id}">`)
        yearEl.append(`<h2>Year: ${getYearDisplayName(year)}</h2>`)

        let facultiesDataEl = $('<div class="faculties-data">')

        for (let faculty of year.faculties) {
            let facultyEl = $(`<div class="faculty-data" id="faculty-data-${faculty.id}">`)
            facultyEl.append(`<h3 class="faculty-name">${faculty.name}</h3>`)

            facultyEl.append(`<div class="chart-container-students">
                <canvas class="students-chart" id="students-chart-${faculty.id}"></canvas>
            </div>`)
            facultyEl.append(`<div class="chart-container-submissions">
                <canvas class="submissions-chart" id="submissions-chart-${faculty.id}"></canvas>
            </div>`)

            facultiesDataEl.append(facultyEl)
        }

        yearEl.append(facultiesDataEl)
        chartsEl.append(yearEl)
    }
}

function createCharts() {
    for (let year of reportData.years) {
        for (let faculty of year.faculties) {
            console.log(faculty)

            createBarChart(
                `students-chart-${faculty.id}`,
                ["Total Students", "Contributor"],
                [faculty.nstudent, faculty.ncontributor],
                faculty.nstudent
            )

            createBarChart(
                `submissions-chart-${faculty.id}`,
                [
                    "Total Submissions",
                    "Selected Submissions",
                    "Submissions w/o comment",
                ],
                [
                    faculty.nsubmission,
                    faculty.nsubmissionselected,
                    faculty.nsubmissionwocomment,
                ],
                faculty.nsubmission
            )
        }
    }
}

const chartCommonOption = {
    legend: {
        display: false,
    },
    scales: {
        xAxes: [{
            ticks: {
                min: 0,
            },
        }],
    },
}

function createBarChart(element, labels, data, maxValue) {
    let option = {
        scales: {
            xAxes: [{
                ticks: {
                    max: maxValue,
                    callback: (value) => getPercentString(value, maxValue)
                }
            }]
        }
    };

    new Chart(element, {
        type: 'horizontalBar',
        data: {
            labels: labels,
            datasets: [{
                data: data
            }]
        },
        options: $.extend(true, option, chartCommonOption)
    })
}

function getPercentString(val, max) {
    return (val / max * 100).toFixed(0) + '%'
}