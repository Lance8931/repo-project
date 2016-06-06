<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户登录</title>
    <@css href="css/bootstrap/bootstrap.min.css" />
    <@js src="js/ECharts/echarts.min.js" />
    <@js src="js/jquery/jquery-1.10.2.js" />
    <@js src="js/bootstrap/bootstrap.min.js" />
</head>
<body>
    <div class="container-fluid">
        <div class="row">
          <div class="col-md-6">
            <div id="main1" style="width: '100%';height:400px;"></div>
          </div>
          <div class="col-md-6">
            <div id="main2" style="width: '100%';height:400px;"></div>
          </div>
        </div>
        <hr />
        <div class="row">
          <div class="col-md-12">
            <div id="main3" style="width: '100%';height:400px;"></div>
          </div>
        </div>
    </div>
    
<script>
    // 基于准备好的dom，初始化echarts实例
        var myChart1 = echarts.init(document.getElementById('main1'));
        var myChart2 = echarts.init(document.getElementById('main2'));
        var myChart3 = echarts.init(document.getElementById('main3'));
        var option1 = {
                title : {
                    text: '大学生分专业毕业人数',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: ['金融','化学化工','工程与材料','信息科学与技术','生物医药','其他']
                },
                series : [
                    {   
                        name: '专业',
                        type: 'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:[
                            {value:335, name:'金融',itemStyle:{normal:{color:'#F06687'}}},
                            {value:310, name:'化学化工',itemStyle:{normal:{color:'#FABE00'}}},
                            {value:234, name:'工程与材料',itemStyle:{normal:{color:'#00A0E6'}}},
                            {value:135, name:'信息科学与技术',itemStyle:{normal:{color:'#00B7F1'}}},
                            {value:158, name:'生物医药',itemStyle:{normal:{color:'#4CBC92'}}},
                            {value:200, name:'其他',itemStyle:{normal:{color:'#FDE599'}}}
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        },
                        labelLine:{
                            normal:{
                                length2:80
                            }
                        },
                        label:{
                            normal:{
                                formatter:'{b}: {d}%'
                            }
                        }
                        
                    }
                ]
            };
        var option2 = {
                title : {
                    text: '就业行业分布比例',
                    x:'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    data:['金融','化学化工','工程与材料','信息科学与技术','生物医药','能源','其他']
                },
                series: [
                    {
                        name:'访问来源',
                        type:'pie',
                        radius: ['30%', '70%'],
                        avoidLabelOverlap: false,
                        labelLine:{
                            normal:{
                                length2:80
                            }
                        },
                        label:{
                            normal:{
                                formatter:'{b}: {d}%'
                            }
                        },
                        data:[
                            {value:335, name:'金融',itemStyle:{normal:{color:'#FDE599'}}},
                            {value:310, name:'化学化工',itemStyle:{normal:{color:'#CCCCCC'}}},
                            {value:234, name:'工程与材料',itemStyle:{normal:{color:'#00A064'}}},
                            {value:135, name:'信息科学与技术',itemStyle:{normal:{color:'#99D9F5'}}},
                            {value:154, name:'生物医药',itemStyle:{normal:{color:'#FABE00'}}},
                            {value:148, name:'能源',itemStyle:{normal:{color:'#F06687'}}},
                            {value:548, name:'其他',itemStyle:{normal:{color:'#33B3EB'}}}
                        ]
                    }
                ]
            };
                    
                var option3 = {
                            title : {
                                text: '职位需求人数与人才市场大差距职业',
                                x:'left'
                            },
                            tooltip : {
                                trigger: 'axis',
                                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                                }
                            },
                            legend: {
                                data:['企业职位需求人数','专业待业人数','应届大学生毕业人数']
                            },
                            grid: {
                                left: '3%',
                                right: '4%',
                                bottom: '3%',
                                containLabel: true
                            },
                            xAxis : [
                                {
                                    type : 'category',
                                    data : ['人力资源经理','科技类文章撰稿人','侦探和刑事调查员','动物科学家','新闻评论员','艺术总监','天文学家','船长/大副和舵手','IOS程序员','数字媒体艺术理论']
                                }
                            ],
                            yAxis : [
                                {
                                    type : 'value'
                                }
                            ],
                            series : [
                                {
                                    name:'企业职位需求人数',
                                    type:'bar',
                                    itemStyle:{
                                        normal:{
                                            color:'#F06687'
                                        }
                                    },
                                    data:[320,332,301,334,390,330,320,390,330,320]
                                },
                                {
                                    name:'专业待业人数',
                                    type:'bar',
                                    itemStyle:{
                                        normal:{
                                            color:'#FABE00'
                                        }
                                    },
                                    data:[120,132,101,134,90,230,210,90,230,210]
                                },
                                {
                                    name:'应届大学生毕业人数',
                                    type:'bar',
                                    itemStyle:{
                                        normal:{
                                            color:'#00A0E6'
                                        }
                                    },
                                    data:[220,182,191,234,290,330,310,290,330,310]
                                }
                            ]
                        };
                
        myChart1.setOption(option1);
        myChart2.setOption(option2);
        myChart3.setOption(option3);
</script>
</body>
</html>