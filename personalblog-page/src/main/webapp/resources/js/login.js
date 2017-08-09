(function(){
    //canvas背景
    var oForm = document.getElementById("form");
    var can = document.getElementById("canvas");
    var ctx = can.getContext("2d");
    var w = can.width = window.innerWidth;
    var h = can.height = window.innerHeight;

    window.onresize = function(){
        w = can.width = window.innerWidth;
        h = can.height = window.innerHeight;
    }
    //面向对象 创建圆形类
    //添加属性
    var dots = [];//存储实例化圆形对象
    function Dot(){
        this.x = Math.random()*w;
        this.y = Math.random()*h;
        this.r = Math.random()*10;
        this.color = color3();
        //坐标更改的速度值
        this.vx = -0.5 + Math.random();
        this.vy = -0.5 + Math.random();
    }
    //添加方法
    Dot.prototype.draw = function(){
        ctx.beginPath();
        var RG = ctx.createRadialGradient(this.x,this.y,0,this.x,this.y,this.r);
        RG.addColorStop(0,this.color);
        RG.addColorStop(1,"rgba(0,0,0,.3)");
        ctx.fillStyle = RG;
        ctx.arc(this.x,this.y,this.r,0,Math.PI*2,false);
        ctx.fill();
        this.update();
    }
    Dot.prototype.update = function(){
        if (this.x < 0 || this.x > w)
        {
            this.vx = -this.vx;
        }
        if (this.y < 0 || this.y > h)
        {
            this.vy = -this.vy;
        }
        this.x += this.vx;
        this.y += this.vy;
    }
    for (var i=0;i<500;i++)
    {
        dots.push(new Dot());
    }
    function drawDots(){
        ctx.clearRect(0,0,w,h);
        for (var i=0,l=dots.length;i<l;i++)
        {
            dots[i].draw();
        }
    }
    setInterval(drawDots,30);
    function color1(){
        var r = Math.floor(Math.random()*256);
        var g = Math.floor(Math.random()*256);
        var b = Math.floor(Math.random()*256);

        return "rgb("+r+","+g+","+b+")";
    }
    function color2(){
        //bug 可能少于6位
        return "#"+(~~(Math.random()*(1<<24))).toString(16);
    }
    function color3(){
        return "#"+function(color){
                //返回一个符合标准的6位的16进制颜色值
                return new Array(7-color.length).join("0") + color;
            }((Math.random()*0x1000000 << 0).toString(16));
    }
    window.addEventListener('mousemove',action);
    /* 鼠标移入表单区域取消canvas粒子连线事件 */
    oForm.addEventListener('mouseover',function(){
        window.removeEventListener('mousemove',action);
    });
    /* 鼠标移入表单区域继续canvas粒子连线事件 */
    oForm.addEventListener('mouseout',function(){
        window.addEventListener('mousemove',action);
    });
    function action(e){
        var arr = [];
        var e = e || window.event;
        var x = e.clientX;
        var y = e.clientY;
        for (var i=0,l=dots.length;i<l;i++)
        {
            if (dots[i].x > x-100 && dots[i].x < x+100 && dots[i].y > y-100 && dots[i].y < y+100)
            {
                arr.push(dots[i]);
            }
        }
        for(var j=0;j<arr.length;j++){
            if (j<arr.length-1)
            {
                ctx.strokeStyle = arr[j].color;
                ctx.beginPath();
                ctx.moveTo(arr[j].x,arr[j].y);
                ctx.lineTo(arr[j+1].x,arr[j+1].y);
                ctx.stroke();
            }
        }
    }
})();
