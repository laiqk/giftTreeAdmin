/*! XMAdmin2016 v0.0.1 | (c) 2015 Jerry */
define("libs/charts",["jQuery","log","raphael"],function(t,r,a){var e=t("jQuery"),h=t("log"),o=h.log;h.warn;h.$();var i=t("raphael");window.Raphael=i,o("raphael is ready, version:",i.version);var n=[{percent:68},{percent:90},{percent:86},{percent:40},{percent:10},{percent:60},{percent:50}],s=function(t){var r=e("#p1-graph");r.empty();var a=r.width(),h=r.height(),o=24,s=48,f=48,l=15,p=a-2*o,c=h-2*o,d=0+o,k=0+o,w=c-s-f,v=20,u=4,F={indexChart1ByWeek:7,indexChart1ByMonth:4,indexChart1By3Months:12},M="number"==typeof F[t]?F[t]:7,g=0,y=[],L=[],Z=[],m=[],b=parseInt((p-2*l-v*M)/(M+1)),x=i(r[0],a,h),A=x.rect(0,0,a,h);A.attr("stroke-width",0),A.attr("fill","#FFFFFF");var B=[],C="#eff6f9",P="#e1e1e1",R="M"+d+","+(k+s)+"L"+d+","+(k+c)+"Z",j="M"+d+","+(k+c)+"L"+(d+p)+","+(k+c)+"Z",I="M"+(d+p)+","+(k+c)+"L"+(d+p)+","+(k+s)+"Z";x.path(R).attr({"stroke-width":1,stroke:C}),x.path(j).attr({"stroke-width":1,stroke:C}),x.path(I).attr({"stroke-width":1,stroke:C});for(var Q=1;4>Q;Q++){var O=k+c-63*Q,T="M"+(d+l)+","+O+"L"+(d+p-l)+","+O+"Z";B.push(x.path(T).attr({"stroke-width":1,stroke:P}))}var W=0,$=0,q=function(){if(!(1>$||$>=M)){var t=L[$-1],r=L[$],a="M"+t[0]+","+t[1]+"L"+r[0]+","+r[1]+"Z";m.push(x.path(a)),m[$-1].attr("stroke-width",2),m[$-1].attr("stroke","#d6a713")}},z=function(){if(!(M>W)){var t=Raphael.animation({fill:"#d6a713","fill-opacity":1},10,"linear",function(){$++,q()});for(g=0,len=L.length;g<len;g++)Z.push(x.circle(L[g][0],L[g][1],u)),Z[g].attr("stroke-width",0),Z[g].attr("fill","rgba(0, 0, 0, 0)"),Z[g].animate(t.delay(100*g))}};for(g=0;M>g;g++){var D=(g+1)*b+g*v,E=w*n[g%n.length].percent/100,G=Math.floor(d+D),H=Math.floor(k+w-E+s-l);y.push(x.rect(G,k+w+s-l,v,0)),y[g].attr("stroke-width",0),y[g].attr("fill","#ffc100"),y[g].animate({y:H,height:E},12*n[g%n.length].percent,"linear",function(){W++,z()}),L.push([G+v/2,H-u+3])}},f=function(t){var r=t.container,a=(t.timeLast,t.colorIndex),e=t.data;r.empty();var h=["#fa5e5b","#22beef"],o=h[a],n=r.width(),s=r.height(),f=48,l=58,p=80,c=34,d=n-p-c,k=s-f-l,w=0+p,v=0+f,u=k,F=7,M=10,g=e.length,y=0,L=[],Z=[],m=d/(g-1),b=i(r[0],n,s),x=b.rect(0,0,n,s);x.attr("stroke-width",0),x.attr("fill","#FFFFFF");var A=[],B="#f3f3f3",C="#f7f7f7",P="M"+w+","+v+"L"+w+","+(v+k)+"Z",R="M"+w+","+(v+k)+"L"+(w+d)+","+(v+k)+"Z",j="M"+(w+d)+","+(v+k)+"L"+(w+d)+","+v+"Z";b.path(P).attr({"stroke-width":1,stroke:B}),b.path(R).attr({"stroke-width":1,stroke:B}),b.path(j).attr({"stroke-width":1,stroke:B});for(var I=0;8>I;I++){var Q=v+k-45*I,O="M"+w+","+Q+"L"+(w+d)+","+Q+"Z";A.push(b.path(O).attr({"stroke-width":2,stroke:C}))}for(var I=1;11>I;I++){var T=w+58*I,O="M"+T+","+v+"L"+T+","+(v+k)+"Z";A.push(b.path(O).attr({"stroke-width":2,stroke:C}))}var W=function(t,r,a){var e=[["M",t[0],t[1]],["L",r[0],r[1]],["Z"]],h="M"+t[0]+","+(v+k)+"L"+r[0]+","+(v+k)+"Z",o=b.path(h);o.attr("stroke-width",5),o.attr("stroke",a),o.animate({path:e},1500),Z.push(o)},$=function(t,r){var a=Raphael.animation({cy:t[1]},1500),e=b.circle(t[0],v+k,M),h=b.circle(t[0],v+k,F);e.attr("stroke-width",1),e.attr("stroke","rgba(0, 0, 0, 0.2)"),h.attr("stroke-width",0),e.attr("fill","#FFFFFF"),h.attr("fill",o),e.animate(a),h.animate(a)};for(y=0;g>y;y++){var q=e[y%e.length].percent,z=y*m,D=u*q/100,E=Math.floor(w+z),G=Math.floor(v+u-D);L.push([E,G,"("+z+", "+D+") ("+E+", "+G+") "+q+"%"]),y>0&&W(L[y-1],L[y],o)}"PathArr"in window||(window.PathArr=[]),window.PathArr.push(Z),y=0;for(var H=L.length;H>y;y++)$(L[y])};r.chartOne=s,r.chartTwo=f});