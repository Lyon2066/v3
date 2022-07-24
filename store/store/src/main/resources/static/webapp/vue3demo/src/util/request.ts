import axios from 'axios'


const fetch = axios.create({
  baseURL: '',
  timeout: 60000
})
fetch.interceptors.request.use(config => {
  return config
}, error => {
  Promise.reject(error)
})

fetch.interceptors.response.use(res => {
  console.log("响应结果" + res)
  return Promise.resolve(res.data)
}, error => Promise.reject(error))

export default fetch
