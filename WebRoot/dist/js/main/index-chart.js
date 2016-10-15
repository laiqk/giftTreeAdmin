/*! XMAdmin2016 v0.0.1 | (c) 2015 Jerry */
define("main/index-chart",["jQuery","log","raphael","libs/charts"],function(e,t,r){var n=e("jQuery"),c=e("log"),a=c.log;c.$();var i=e("raphael");"Raphael"in window||(window.Raphael=i,a("raphael is ready, version:",i.version));var p=e("libs/charts"),s=[{percent:68},{percent:90},{percent:86},{percent:40},{percent:10},{percent:60},{percent:50}],h=10,o=60,l=s.length,d=0,v=0,g=function(e){var t=0,r=[],n=i(e[0],e.width(),e.height());for(t=0;l>t;t++){var c=2*t*h,a=o*s[t].percent/100,p=Math.floor(d+c),g=Math.floor(v+o-a);r.push(n.rect(p,v+o,h,0)),r[t].attr("stroke-width",0),r[t].attr("fill","rgba(255, 255, 255, 0.3)"),r[t].animate({y:g,height:a},20*s[t].percent,"linear")}},f=p.chartOne,w=p.chartTwo;r.exports=function(){var e={week:[{percent:50.25},{percent:87.68},{percent:5.24},{percent:96.55},{percent:76.46},{percent:55},{percent:13.84}],month:[{percent:3.42},{percent:32.94},{percent:82.17},{percent:10.55}],months:[{percent:40.83},{percent:19.49},{percent:8.21},{percent:96.52},{percent:92.18},{percent:14.11},{percent:97.41},{percent:51.81},{percent:1.93},{percent:60.49},{percent:26.31},{percent:25.66}]},t={week:[{percent:61.49},{percent:82.7},{percent:39.53},{percent:55.94},{percent:21.71},{percent:13.56},{percent:90.91}],month:[{percent:68.27},{percent:14.79},{percent:14.07},{percent:14.78}],months:[{percent:32.83},{percent:42.29},{percent:62.13},{percent:96.52},{percent:90.87},{percent:3.86},{percent:17.84},{percent:86.92},{percent:95.67},{percent:26.18},{percent:74.1},{percent:74.75}]};n(".data-show-graph").each(function(e,t){g(n(t))}),f(),n("#indexChart1ByWeek, #indexChart1ByMonth, #indexChart1By3Months").on("click",function(){if(!n(this).hasClass("active")){n(this).addClass("active").siblings("a").removeClass("active");var e=n(this).attr("id");f(e)}}),n("#c2-week, #c2-month, #c2-months").on("click",function(){if(!n(this).hasClass("active")){n(this).addClass("active").siblings("a").removeClass("active");var t=(n(this).attr("id"),n(this).data("type"));w({container:n("#p2-graph-1"),data:e[t],colorIndex:0})}}),n("#c3-week, #c3-month, #c3-months").on("click",function(){if(!n(this).hasClass("active")){n(this).addClass("active").siblings("a").removeClass("active");var e=(n(this).attr("id"),n(this).data("type"));w({container:n("#p2-graph-2"),data:t[e],colorIndex:1})}}),n("#c2-week").trigger("click"),n("#c3-week").trigger("click")}});