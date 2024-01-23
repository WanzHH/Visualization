import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'
import VueAxios from "vue-axios";
import echarts from 'echarts'

Vue.config.productionTip = false
// 使用 ElementUI 插件
Vue.use(ElementUI);
// 使用 VueAxios 插件，并将 axios 配置给 VueAxios
Vue.use(VueAxios, axios);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

