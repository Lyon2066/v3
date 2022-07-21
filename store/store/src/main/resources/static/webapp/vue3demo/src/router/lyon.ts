import { RouteRecordRaw } from "vue-router"
import Home from "../views/Home.vue"
import About from "../views/About.vue"
import Login from "../views/Login.vue"
import Register from "../views/Register.vue"
const routes: Array<RouteRecordRaw> = [
  { path: "/", name: "home", component: Home },
  { path: "/home", name: "home", component: Home },
  { path: "/about", name: "about", component: About },
  { path: "/login", name: "login", component: Login },
  { path: "/register", name: "register", component: Register },
]
export default routes
