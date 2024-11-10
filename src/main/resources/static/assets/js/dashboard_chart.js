
~function($) {

    var data = "charttype"
    var Selector = {
        page: '.page-body'
    }
    var ChartType = {
        chartJS: 'chartJS',
        echart: 'echart'
    }
    if($(Selector.page).data(data) == ChartType.chartJS) {
        /**
         * [ChartJS 具体示例]
         * @type {[type]}
         */
        var lineCanvas = $('#lineChart').get(0).getContext('2d')
        var doughnutCanvas = $('#doughnutChart').get(0).getContext('2d')
        var barCanvas = $('#barChart').get(0).getContext('2d')
        var lineChart = new Chart(lineCanvas, {
            type: 'line',
            data: {
                labels: ["09-01", "09-02", "09-03", "09-04", "09-05", "09-06"],
                datasets: [{
                    label: '折线图',
                    data: [1, 30, 2, 15, 45, 16],
                    backgroundColor: 'rgba(35,153,199,1)',
                    borderColor: 'rgba(35,153,199,1)',
                    borderWidth: 1,
                    fill: false
                }]
            },
            options: {
                animation: {
                    easing: 'easeInOutCubic',
                },
                legend: {
                    display: true,
                    labels: {
                        boxWidth:100,
                        usePointStyle: true
                    }
                }
            }
        })
        var doughnutChart = new Chart(doughnutCanvas, {
            type: 'doughnut',
            data: {
                datasets: [{
                    data: [700, 500, 600, 300, 100, 400],
                    backgroundColor: [
                        'rgba(255, 108, 96, 1)',
                        'rgba(255, 153, 78, 1)',
                        'rgba(245, 217, 74, 1)',
                        'rgba(40, 193, 110, 1)',
                        'rgba(29, 159, 189, 1)'
                    ],
                    label: '浏览器使用'
                }],
                labels: [
                    'Chrome',
                    'FireFox',
                    'IE',
                    'Safari',
                    'Opera',
                    'Navigator'
                ]
            },
            options: {
                animation: {
                    easing: 'easeOutBounce',
                },
                legend: {
                    display: true,
                    labels: {
                        boxWidth:100,
                        usePointStyle: true
                    }
                }
            }
        })
        var barChart = new Chart(barCanvas, {
            type: 'bar',
            data: {
                labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
                datasets:[{
                    data: [12, 19, 3, -5, 2, 3],
                    label: '柱形图',
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }],
            },
            options: {
                responsive: true,
                legend: {
                    position: 'top'
                },
                title: {
                    display: true,
                    text:'柱形图'
                },
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero:true
                        }
                    }]
                }
            }
        })
    }else {
        var ECline = $('#lineChart').get(0)
        var ECbar = $('#barChart').get(0)
        var ECpie = $('#pieChart').get(0)
        var EClineChart = echarts.init(ECline)
        var ECbarChart = echarts.init(ECbar)
        var ECpieChart = echarts.init(ECpie)
        // 使用刚指定的配置项和数据显示图表。
        EClineChart.setOption({
            xAxis: {
                type: 'category',
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: [820, 932, 901, 934, 1290, 1330, 1320],
                type: 'line'
            }]
        })
        ECbarChart.setOption({
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        })
        ECpieChart.setOption({
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
            },
            series: [{
                name:'访问来源',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:335, name:'直接访问'},
                    {value:310, name:'邮件营销'},
                    {value:234, name:'联盟广告'},
                    {value:135, name:'视频广告'},
                    {value:1548, name:'搜索引擎'}
                ]
            }]
        })
    }
}(jQuery)