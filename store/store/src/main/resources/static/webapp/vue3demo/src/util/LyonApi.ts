// @ts-ignore
import fetch from "./request";

export const usersReg = (params: unknown) => {
  return fetch({
    url: '/Lyon/users/reg',
    method: 'GET',
    params
  })
}

export const usersLogin = (data: unknown) => {
  return fetch({
    url: '/Lyon/users/login',
    method: 'POST',
    data
  })
}