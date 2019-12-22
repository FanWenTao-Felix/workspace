import request from '@/utils/request'
export const getList = (current, size, params) => {
  return request({
    url: '/springcloud-develop/dbinstance/list/page',
    method: 'get',
    params: {
      ...params,
      current,
      size
    }
  })
}

export const getDetail = (id) => {
  return request({
    url: '/springcloud-develop/dbinstance/detail',
    method: 'get',
    params: {
      id
    }
  })
}

export const remove = (ids) => {
  return request({
    url: '/springcloud-develop/dbinstance/remove',
    method: 'post',
    params: {
      ids
    }
  })
}

export const add = (row) => {
  return request({
    url: '/springcloud-develop/dbinstance/submit',
    method: 'post',
    data: row
  })
}

export const update = (row) => {
  return request({
    url: '/springcloud-develop/dbinstance/submit',
    method: 'post',
    data: row
  })
}