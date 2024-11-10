~ function($) {

    $( ".widget-drag" ).sortable({
        placeholder: "sort-highlight",
        connectWith         : '.widget-drag',
        handle              : '.box-header,.small-box-icon',
        forcePlaceholderSize: true,
        zIndex              : 999999,
        helper: "clone",
        revert: true,
        opacity: 0.8,
        delay: 100,
        tolerance: "pointer"
    });
    /**
     * [IDName TinyMCE]
     * @type {Object}
     */
    var TyMCEIDName = {
        postEditArea: '#postEditArea',
        emailEditArea: '#emailEditArea',
    }
    var lineCanvas = $('#lineChart').get(0).getContext('2d')
    var doughnutCanvas = $('#doughnutChart').get(0).getContext('2d')
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
                    boxWidth: 100,
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
                    boxWidth: 100,
                    usePointStyle: true
                }
            }
        }
    })

    $(document).on('ready', function(event) {
        /**
         * [TinyMCE富文本编辑器]
         * @type {String}
         */
        tinymce.init({
            selector: 'textarea' + TyMCEIDName.postEditArea,
            height: 150,
            menubar: false,
            branding: false,
            language: "zh_CN",
            resize: false,
            plugins: [
                'advlist autolink lists link image charmap print preview anchor textcolor',
                'searchreplace visualblocks code fullscreen',
                'insertdatetime media table contextmenu paste code help wordcount'
            ],
            toolbar: 'insert | undo redo |  formatselect | bold italic backcolor  | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | removeformat',
        })
        tinymce.init({
            selector: 'textarea' + TyMCEIDName.emailEditArea,
            height: 150,
            menubar: false,
            branding: false,
            language: "zh_CN",
            resize: false,
            plugins: [
                'advlist autolink lists link image charmap print preview anchor textcolor',
                'searchreplace visualblocks code fullscreen',
                'insertdatetime media table contextmenu paste code help wordcount'
            ],
            toolbar: 'insert | undo redo |  formatselect | bold italic backcolor  | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | removeformat',
        })
    })
}(jQuery)