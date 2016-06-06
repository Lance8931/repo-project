$(function() {
    $("#_body").css({"min-height": "640px","min-width": "1000px"});
    /* 加载菜单 */
    BUI.use('common/main', function() {
        var config = [ {
            id:'userinfo',
            homePage : 'personal-info',
            menu:[{
                text:'个人中心',
                items:[
                  {id:'personal-info',text:'我的资料',href:createUrl('admin/hrEmployee/view'),closeable : false},
                  {id:'change-pwd',text:'修改密码',href:createUrl('view/user/updatePassWord')}
                ]
              }]
          }, {
            id : 'menu',
            homePage : 'default-user',
            menu : [ {
                text : '用户管理',
                items : [ {
                    id : 'default-user',
                    text : '本单位用户',
                    href : createUrl("view/user/emp/list")
                }, /*{
                    id : 'personal-user',
                    text : '普通个人用户',
                    href : createUrl("userPsersonal/redirectList")
                }, {
                    id : 'org-user',
                    text : '招聘企业用户',
                    href : createUrl("view/user/org/list")
                },*/{
                    id : 'enter-user',
                    text : '园区入驻企业申请',
                    href : createUrl("/enterprise/apply/page")
                }, {
                    id : 'enter-user',
                    text : '园区入驻企业',
                    href : createUrl("view/user/enterprise/list")
                } ]
            }, {
                text:'权限管理',
                items:[
                  {id:'group-role',text:'角色',href:createUrl("view/user/role")},
                  {id:'permission',text:'权限',href:createUrl("view/user/permission")}
                ]
            }, {
                text : '门户设置',
                items : [ {
                    id : 'slide-pic',
                    text : '首页幻灯片',
                    href : createUrl("slidePic/list/page")
                }, {
                    id : 'notification',
                    text : '通知/公告',
                    href : createUrl("article/redirectArticle?type=1")
                }, {
                    id : 'latest-news',
                    text : '最新资讯',
                    href : createUrl("article/redirectArticle?type=2")
                }, {
                    id : 'park-info',
                    text : '园区概况',
                    href : createUrl("article/redirectIntro?type=park-info")
                }, {
                    id : 'org-incoming',
                    text : '企业入园',
                    href : createUrl("article/redirectIntro?type=org-incoming")
                }, {
                    id : 'innovative',
                    text : '创新创业',
                    href : createUrl("article/redirectIntro?type=innovative")
                }, {
                    id : 'oversea-innovative',
                    text : '离岸创新创业',
                    href : createUrl("article/redirectIntro?type=oversea-innovative")
                }/*, {
                    id : 'contact-us',
                    text : '联系我们',
                    href : createUrl("")
                }, {
                    id : 'site-params',
                    text : '网站参数',
                    href : createUrl("admin/siteParams")
                }*/ ]
            }/*, {
                text : '高层次人才管理',
                items : [ {
                    id : 'talent-search',
                    text : '人才查询',
                    href : 'main/resource.html'
                }, {
                    id : 'talent-check',
                    text : '人才审核',
                    href : 'main/loader.html'
                } ]
            }*/ ]
          }, {
              id:'report',
              menu:[{
                  text:'报表',
                  items:[
                    {id:'employment',text:'精准指导就业',href:createUrl("report/employment")}
                  ]
                }]
            } ];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
});