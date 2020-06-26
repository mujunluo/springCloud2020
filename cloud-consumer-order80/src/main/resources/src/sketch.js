var data=[];//点坐标
/**
 * 初始函数
 */
function setup() {
    createCanvas(400,400);
    background(0,3,3);
}
var alpha0=0;
var alpha1=0;
var a0=0;
var a1=0;
var a2=0;
var beta0=0;
/**
 * 二次函数
 */
function unLinearRegression(){
    var xsum=0;//x的和
    var ysum=0;//y的和

    for(var i=0;i<data.length;i++){
        xsum+=data[i].x;
        ysum+=data[i].y;
    }
    var length=data.length;//p0(x)=1,所以p0(x)的和就是数据长度
    alpha0=xsum/data.length;//α0
    var p1data=[];//p1(x)
    var p1p1sum=0;//p1*p1 多项式的和
    var xp1p1sum=0;//x*p1*p1 多项式的和
    for(var i=0;i<data.length;i++){
        var p1=data[i].x-alpha0;
        p1p1sum+=p1*p1;
        xp1p1sum+=data[i].x*p1*p1;
        p1data.push(p1);
    }
    alpha1=xp1p1sum/p1p1sum;//α1
    beta0=p1p1sum/length;//β0
    var p2data=[];//p2(x)
    var p2p2sum=0;//p2*p2 多项式的和
    var xp2p2sum=0;//x*p2*p2 多项式的和
    for(var i=0;i<data.length;i++){
        var p2=(data[i].x-alpha1)*p1data[i]-beta0;
        p2data.push(p2);
        p2p2sum+=p2*p2;
        xp2p2sum+=data[i].x*p2*p2;
    }
    //var alpha2=xp2p2sum/p2p2sum;
    var fp0=ysum;//y*p0 多项式的和
    var fp1=0;//y*p1 多项式的和
    var fp2=0;//y*p2 多项式的和
    for(var i=0;i<data.length;i++){
        fp1+=data[i].y*p1data[i];
        fp2+=data[i].y*p2data[i];
    }
    a0=fp0/length;//g(x)=a0*p0(x)+a1*p1(x)+a2*p2(x) 二次多项式拟合公式
    a1=fp1/p1p1sum;
    a2=fp2/p2p2sum;
}
/**
 * 画曲线
 */
function drawCurve(){
    var newdata=[];//二次多项式 点数据
    for(var i=0;i<100;i++){//生成100个点画曲线
        var x=i*100;
        var pp1x=x-alpha0;
        var pp2x=(x-alpha1)*(x-alpha0)-beta0;
        var y=(a0+a1*pp1x+a2*pp2x);
        /*var y=x*x+90;*/
        var point=createVector(x,y);
        newdata.push(point);
    }
    //b=x*x;
    var i=0;
    noFill();
    //三个点即可形成一条曲线
    if(i<newdata.length){
        var p1x=newdata[i].x;
        var p1y=newdata[i].y;
        p1x=map(p1x,0,100,0,width);
        p1y=map(p1y,0,100,height,0);
        i++;
        var p2x=newdata[i].x;
        var p2y=newdata[i].y;
        p2x=map(p2x,0,100,0,width);
        p2y=map(p2y,0,100,height,0);
        i++;
        var p3x=newdata[i].x;
        var p3y=newdata[i].y;
        p3x=map(p3x,0,100,0,width);
        p3y=map(p3y,0,100,height,0);
        i++;
        /*      var p4x=newdata[i].x;
                var p4y=newdata[i].y;
                p4x=map(p4x,0,100,0,width);
                p4y=map(p4y,0,100,height,0);
                i++;*/
        var p1 = {x: p1x, y: p1y};
        var p2 = {x: p2x, y: p2y};
        var p3 = {x: p3x, y: p3y};
        //var p4 = {x: p4x, y: p4y};
        noFill();
        stroke(138, 43, 226);//曲线颜色 - 紫罗兰色
        strokeWeight(4);//曲线宽度
        curve(p1.x, p1.y, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
    }
}
/**
 * 鼠标点击
 */
function mousePressed(){
    var x=map(mouseX,0,width,0,100);
    var y=map(mouseY,0,height,100,0);
    var point = createVector(x,y);
    data.push(point);
}
/**
 * 绘画（点和线）
 */
function draw() {
    background(50);
    for(var i=0;i<data.length;i++){
        var x=map(data[i].x,0,100,0,width);
        var y=map(data[i].y,0,100,height,0);
        fill(255,0,0);//设置填充颜色
        stroke(255);//设置边框颜色
        strokeWeight(2);//设置点的宽度
        ellipse(x,y,10,10);//椭圆
    }
    if(data.length>2){
        unLinearRegression();
        drawCurve();
    }
}