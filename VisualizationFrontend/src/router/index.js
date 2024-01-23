import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import mapChina from '@/views/VisualiazationMap/MapChinaView.vue'
import UserView from "@/views/UserView.vue";
import MapView from "@/views/MapView.vue";
import mapWorld from "@/views/VisualiazationMap/MapWorldView.vue";
import mentalHealth from "@/views/VisualizationUser/MentalHealthView.vue";
import sleepHealth from "@/views/VisualizationUser/sleepHealthView.vue";
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/home',
    name: 'home',
    component: HomeView
  },
  {
    path: '/toUser',
    name: 'userHome',
    component: UserView
  },
  {
    path: '/toMaps',
    name: 'maps',
    component: MapView
  },
  {
    path: '/Register',
    name: 'Register',
    component: Register
  },
  {
    path: '/mapChina',
    name: 'mapChina',
    component: mapChina
  },
  {
    path: '/mapWorld',
    name: 'mapWorld',
    component: mapWorld
  },
  {
    path: '/mentalHealth',
    name: 'mentalHealth',
    component: mentalHealth
  },
  {
    path: '/sleepHealth',
    name: 'sleepHealth',
    component: sleepHealth
  }
]

const router = new VueRouter({
  routes,
  mode: "history"
})
export default router
