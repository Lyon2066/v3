import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// import store from './store'
import Vant from 'vant';
import { createPinia } from 'pinia';
import 'vant/lib/index.css';
// createApp(App).use(store).use(router).use(Vant).mount('#app')
createApp(App).use(createPinia()).use(router).use(Vant).mount('#app')