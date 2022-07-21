import {createRouter,createWebHashHistory,createWebHistory} from "vue-router"
import routes from "./lyon"

const router = createRouter({
  history:  createWebHistory(),
  routes
})
export default router