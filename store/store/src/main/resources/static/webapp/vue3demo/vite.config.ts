import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import Components from 'unplugin-vue-components/vite'
import { VantResolver } from 'unplugin-vue-components/resolvers';
import { rewriteDefault } from '@vue/compiler-sfc';
const path = require('path')
const resolve = (dir: string) => {
  return path.join(__dirname, dir)
}
// https://vitejs.dev/config/
export default defineConfig({
  server: {
    proxy: {
      "/Lyon": {
        target: 'http://127.0.0.1:8080',
        changeOrigin: true,
        rewrite: (path) => {
            return path.replace(/^\/Lyon/,'')
        },
      }
    }
  },
  plugins: [
    vue(),
    Components({
      resolvers: [VantResolver()]
    })
  ],
  resolve: {
    alias: {
      '@': resolve('./src'),
      'components': resolve('./src/component')
    }
  }
})
