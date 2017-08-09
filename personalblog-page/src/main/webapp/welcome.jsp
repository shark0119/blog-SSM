<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>  <!DOCTYPE html>
<html>
<head>
	<title>Detail Admin - Home</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
    <link href="${ctx }/resources/blog/back/welcome/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="${ctx }/resources/blog/back/welcome/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="${ctx }/resources/blog/back/welcome/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- libraries -->
    <link href="${ctx }/resources/blog/back/welcome/css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />
    <link href="${ctx }/resources/blog/back/welcome/css/lib/font-awesome.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/welcome/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/welcome/css/elements.css" />
    <link rel="stylesheet" type="text/css" href="${ctx }/resources/blog/back/welcome/css/icons.css" />

    <!-- this page specific styles -->
    <link rel="stylesheet" href="${ctx }/resources/blog/back/welcome/css/compiled/index.css" type="text/css" media="screen" />    

    <!-- open sans font -->

    <!-- lato font -->

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

    <!-- navbar -->
   
    <!-- end navbar -->

    <!-- sidebar -->
   
    <!-- end sidebar -->


	<!-- main container -->
    <div class="content" style="margin:0px;">

        <!-- settings changer -->
        

        <div class="container-fluid">

            <!-- upper main stats -->
            <div id="main-stats">
                <div class="row-fluid stats-row">
                    <div class="span3 stat">
                        <div class="data">
                            <span class="number">245</span>
                            点击量
                        </div>
                        <span class="date">最近一月</span>
                    </div>
                    <div class="span3 stat">
                        <div class="data">
                            <span class="number">32</span>
                            用户活跃度
                        </div>
                        <span class="date">最近一月</span>
                    </div>
                    <div class="span3 stat">
                        <div class="data">
                            <span class="number">322</span>
             评论数        
                        </div>
                        <span class="date">最近一月</span>
                    </div>
                    <div class="span3 stat last">
                        <div class="data">
                            <span class="number">153</span>
                            点赞
                        </div>
                        <span class="date">最近一月</span>
                    </div>
                </div>
            </div>
            <!-- end upper main stats -->

            <div id="pad-wrapper">

                <!-- statistics chart built with jQuery Flot -->
                <div class="row-fluid chart">
                    <h4>
                        Statistics
                         <div class="btn-group pull-right">
                            <button class="glow middle active">MONTH</button>
                        </div>
                    </h4>
                    <div class="span12">
                        <div id="statsChart"></div>
                    </div>
                </div>
             
            </div>
        </div>
    </div>


	<!-- scripts -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="${ctx }/resources/blog/back/welcome/js/bootstrap.min.js"></script>
    <script src="${ctx }/resources/blog/back/welcome/js/jquery-ui-1.10.2.custom.min.js"></script>
    <!-- knob -->
    <script src="${ctx }/resources/blog/back/welcome/js/jquery.knob.js"></script>
    <!-- flot charts -->
    <script src="${ctx }/resources/blog/back/welcome/js/jquery.flot.js"></script>
    <script src="${ctx }/resources/blog/back/welcome/js/jquery.flot.stack.js"></script>
    <script src="${ctx }/resources/blog/back/welcome/js/jquery.flot.resize.js"></script>
    <script src="${ctx }/resources/blog/back/welcome/js/theme.js"></script>

    <script type="text/javascript">
        $(function () {

            // jQuery Knobs
            $(".knob").knob();



            // jQuery UI Sliders
            $(".slider-sample1").slider({
                value: 100,
                min: 1,
                max: 500
            });
            $(".slider-sample2").slider({
                range: "min",
                value: 130,
                min: 1,
                max: 500
            });
            $(".slider-sample3").slider({
                range: true,
                min: 0,
                max: 500,
                values: [ 40, 170 ],
            });

            

            // jQuery Flot Chart
            var visits = [[1, 50], [2, 40], [3, 45], [4, 23],[5, 55],[6, 65],[7, 61],[8, 70],[9, 65],[10, 75],[11, 57],[12, 59]];
            var visitors = [[1, 25], [2, 50], [3, 23], [4, 48],[5, 38],[6, 40],[7, 47],[8, 55],[9, 43],[10,50],[11,47],[12, 39]];

            var plot = $.plot($("#statsChart"),
                [ { data: visits, label: "Signups"},
                 { data: visitors, label: "Visits" }], {
                    series: {
                        lines: { show: true,
                                lineWidth: 1,
                                fill: true, 
                                fillColor: { colors: [ { opacity: 0.1 }, { opacity: 0.13 } ] }
                             },
                        points: { show: true, 
                                 lineWidth: 2,
                                 radius: 3
                             },
                        shadowSize: 0,
                        stack: true
                    },
                    grid: { hoverable: true, 
                           clickable: true, 
                           tickColor: "#f9f9f9",
                           borderWidth: 0
                        },
                    legend: {
                            // show: false
                            labelBoxBorderColor: "#fff"
                        },  
                    colors: ["#a7b5c5", "#30a0eb"],
                    xaxis: {
                        ticks: [[1, "JAN"], [2, "FEB"], [3, "MAR"], [4,"APR"], [5,"MAY"], [6,"JUN"], 
                               [7,"JUL"], [8,"AUG"], [9,"SEP"], [10,"OCT"], [11,"NOV"], [12,"DEC"]],
                        font: {
                            size: 12,
                            family: "Open Sans, Arial",
                            variant: "small-caps",
                            color: "#697695"
                        }
                    },
                    yaxis: {
                        ticks:3, 
                        tickDecimals: 0,
                        font: {size:12, color: "#9da3a9"}
                    }
                 });

            function showTooltip(x, y, contents) {
                $('<div id="tooltip">' + contents + '</div>').css( {
                    position: 'absolute',
                    display: 'none',
                    top: y - 30,
                    left: x - 50,
                    color: "#fff",
                    padding: '2px 5px',
                    'border-radius': '6px',
                    'background-color': '#000',
                    opacity: 0.80
                }).appendTo("body").fadeIn(200);
            }

            var previousPoint = null;
            $("#statsChart").bind("plothover", function (event, pos, item) {
                if (item) {
                    if (previousPoint != item.dataIndex) {
                        previousPoint = item.dataIndex;

                        $("#tooltip").remove();
                        var x = item.datapoint[0].toFixed(0),
                            y = item.datapoint[1].toFixed(0);

                        var month = item.series.xaxis.ticks[item.dataIndex].label;

                        showTooltip(item.pageX, item.pageY,
                                    item.series.label + " of " + month + ": " + y);
                    }
                }
                else {
                    $("#tooltip").remove();
                    previousPoint = null;
                }
            });
        });
    </script>

</body>
</html>  
    