<template>
  <div>
    <div class="ztmy-pcmove-menu drag-and-drop" id="pcMenu" style="top: 58px; left: 93px;">
      <div class="title f-px">Menu</div>
      <div class="ztmy-pcmove-inner">
        <ul class="ztmy-pcmove-cont">
          <li><a href="/mapChina/"><p class="f-px">中国</p></a></li>
          <li><a href="/mapWorld/"><p class="f-px">世界</p></a></li>
          <li><a href="/home/"><p class="f-px">返回主页</p></a></li>
          <!-- <li class="comingsoon"><a href="javascript:void();"><p class="f-px">PREMIUM<img src="/themes/zutomayo/_assets/img/icon_nav_premium.png" class="icon"></p></a></li> -->
        </ul>
        <a href="#" class="btn-close-menu" data-close="#pcMenu"></a>
      </div>
    </div>
  </div>
</template>



<script>
import $ from 'jquery'
import gsap from 'gsap';
import { Power2 } from 'gsap';
export default {
  name: 'menuStu',
  data() {
    return {};
  },
  created:function () {
    /*
  * zutomayo.net
  * update 2021.6.24
  */

    //--------------------------------------------------
    //
    //  WindowDraggble DOMドラッグ
    //
    //--------------------------------------------------
    var WindowDraggble = (function(){

      let _mode = false;
      return{
        Init: function(url){

          //要素の取得
          var elements = document.getElementsByClassName("drag-and-drop");

          //要素内のクリックされた位置を取得するグローバル（のような）変数
          var x;
          var y;

          //マウスが要素内で押されたとき、又はタッチされたとき発火
          for(var i = 0; i < elements.length; i++) {
            elements[i].addEventListener("mousedown", mdown, false);
            elements[i].addEventListener("touchstart", mdown, false);
          }

          //マウスが押された際の関数
          function mdown(e) {
            _mode = true;
            //クラス名に .drag を追加
            this.classList.add("drag");

            //タッチデイベントとマウスのイベントの差異を吸収
            if(e.type === "mousedown") {
              var event = e;
            } else {
              var event = e.changedTouches[0];
            }

            //要素内の相対座標を取得
            x = event.pageX - this.offsetLeft;
            y = event.pageY - this.offsetTop;

            //ムーブイベントにコールバック
            document.body.addEventListener("mousemove", mmove, false);
            document.body.addEventListener("touchmove", mmove, false);
          }

          //マウスカーソルが動いたときに発火
          function mmove(e) {

            //ドラッグしている要素を取得
            var drag = document.getElementsByClassName("drag")[0];

            //同様にマウスとタッチの差異を吸収
            if(e.type === "mousemove") {
              var event = e;
            } else {
              var event = e.changedTouches[0];
            }

            //フリックしたときに画面を動かさないようにデフォルト動作を抑制
            e.preventDefault();

            //マウスが動いた場所に要素を動かす
            drag.style.top = event.pageY - y + "px";
            drag.style.left = event.pageX - x + "px";

            //マウスボタンが離されたとき、またはカーソルが外れたとき発火
            drag.addEventListener("mouseup", mup, false);
            document.body.addEventListener("mouseleave", mup, false);
            drag.addEventListener("touchend", mup, false);
            document.body.addEventListener("touchleave", mup, false);

          }

          //マウスボタンが上がったら発火
          function mup(e) {

            var drag = document.getElementsByClassName("drag")[0];

            //ムーブベントハンドラの消去
            document.body.removeEventListener("mousemove", mmove, false);
            if(drag){
              drag.removeEventListener("mouseup", mup, false);
            }
            document.body.removeEventListener("touchmove", mmove, false);
            if(drag){
              drag.removeEventListener("touchend", mup, false);
            }

            //クラス名 .drag も消す
            if(drag){
              drag.classList.remove("drag");

            }
            _mode = false;

          }


          $('.btn-close,.btn-no').on('click',function(e){
            mup();
            WindowDraggble.Close($(this).data('close'));
            e.preventDefault();
          });

          $('.btn-close-menu,.header-bar').on('click',function(e){
            mup();
            WindowDraggble.Mini($(this).data('close'));
            e.preventDefault();
          });

          $(".drag-and-drop a").on('click',function(){
            mup();
          });


          // $("#spNews").on('touchend',function(){
          //   WindowDraggble.Mini("#spNews");
          // });

        },
        Close:function(target){
          console.log(target);
          // $(target).addClass("windowclose");
          $(target).fadeOut(150);
        },
        Mini:function(target){
          console.log(target);
          // $(target).addClass("windowclose");
          $(target).toggleClass("windowmini");
        }
      }
    })();



    $(function(){
      WindowDraggble.Init();

      let spMenu = $("#spNews.windowmini");
      $(window).on("load",function(){
        gsap.to(spMenu, 0.2, {right: 0,delay: 0,ease: Power2.easeInOut});
      });

    })

  },

};

</script>

<style>
@font-face {
  font-family: 'pixelmplus12regular';
  src: url('../../css/fonts/PixelMplus12-Regular.woff.ttf') format('woff');
  /* 添加其他格式的字体文件路径和声明，以确保在不同浏览器中的兼容性 */
  font-weight: normal;
  font-style: normal;
}
.ztmy-pcmove-inner {
  position: relative;
  padding: 59px 8px 0 8px;
}

.ztmy-pcmove-cont {
  margin: 0 ;
  padding: 0;
  list-style: none;
}
.ztmy-pcmove-cont li {
  margin: 1px 1rem;
}
.f-px {
  font-family: 'pixelmplus12regular',serif;
  font-weight: normal;
  font-style: normal;
}

.drag-and-drop {
  cursor: move;
  position: fixed;
  z-index: 1000;
}
.ztmy-pcmove-menu {
  display: block;
  position: fixed;
  z-index: 300;
  top: 80px;
  left: 26px;
  height: 400px;
  background-size: 100%;
  background-position: top;
  background-repeat: no-repeat;
  background-color: #E8D2E9;
  border: solid 1px #6F2ADD;
  box-shadow: 3px 3px 0 #A3919E;
  overflow: hidden;
  transition: height 0.3s;
}
*, *::before, *::after {
  box-sizing: border-box;
}
.ztmy-pcmove-inner .btn-close-menu {
  position: absolute;
  top: 11px;
  right: 11px;
  width: 28px;
  height: 28px;
  font-size: 0;
  line-height: 0;
  background-image: url("../../assets/img/btn_news_window_close.png");
  background-size: contain;
  background-position: center;
  background-repeat: no-repeat;
}

.ztmy-pcmove-menu .title {
  margin: 0;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 46px;
  line-height: 26px;
  color: #fff;
  background-color: #6F2ADD;
  padding: 10px;
  font-size: 20px;
}
.ztmy-pcmove-menu.windowmini .btn-close-menu {
  background-image: url("../../assets/img/btn_news_window_open.png");
}
.ztmy-pcmove-menu.windowmini {
  height: 46px;
}


a {
  color: #000000;
  text-decoration: none;
  transition: all 0.3s;
  letter-spacing: 0.1em;
}

</style>
