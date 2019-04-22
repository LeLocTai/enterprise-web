let reportData = {};

const chartsEl = $('#charts')
const formEl = $('#input-form')

formEl.submit((e) => {
    e.preventDefault();

    $.get('report-data', $(e.target).serialize())
        .done((res) => {
            reportData = JSON.parse(res);
            console.log(reportData);
            createDOMElements()
            createCharts()
        })
});
formEl.submit()

function getYearDisplayName(year) {
    return year.startdate.substr(0, year.startdate.indexOf('-'));
}

function createDOMElements() {
    chartsEl.empty()

    for (let year of reportData.years) {
        //Header
        let yearEl = $(`<div class="year-data" id="year-data-${year.id}">`)
        yearEl.append(`<h2>Year: ${getYearDisplayName(year)}</h2>`)

        //Faculties contribs
        let facultiesContribEl = $(`<div class="faculties-contrib">`)
        facultiesContribEl.append(createChartEl('faculties', year.id))
        yearEl.append(facultiesContribEl)

        //Faculties details
        let facultiesDataEl = $('<div class="faculties-data">')
        for (let faculty of year.faculties) {
            let facultyEl = $(`<div class="faculty-data" id="faculty-data-${faculty.id}">`)
            facultyEl.append(`<h3 class="faculty-name">${faculty.name}</h3>`)

            facultyEl.append(createChartEl('students', faculty.id))
            facultyEl.append(createChartEl('submissions', faculty.id))

            facultiesDataEl.append(facultyEl)
        }
        yearEl.append(facultiesDataEl)
        
        
        chartsEl.append(yearEl)
    }
}

function createChartEl(typeName, id) {
    let container = $(`<div class="chart-container chart-container-${typeName}">`)
    let canvas = $(`<canvas class="${typeName}-chart" id="${typeName}-chart-${id}">`)

    container.append(canvas);
    return container
}

function createCharts() {
    for (let year of reportData.years) {
        createFacultiesContribChart(year.id, year.faculties)

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

function createFacultiesContribChart(yearId, faculties) {
    let labels = []
    let data = []

    for (let f of faculties) {
        labels.push(f.name)
        data.push(f.nsubmission)
    }

    new Chart(`faculties-chart-${yearId}`, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                data: data
            }]
        },
        options: {}
    });
}

function createBarChart(element, labels, data, maxValue) {
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