import axios from 'axios'

export function fetch(url,method,data) {
  return new Promise(() => {
    axios({
      method,
      url,
      data,
      params:data
    });
  })
}
