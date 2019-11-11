import request from '@/utils/request'

export const getList = (current, size, params) => {
  return request({
    url: '/springcloud-develop/datasource/list',
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
    url: '/springcloud-develop/datasource/detail',
    method: 'get',
    params: {
      id
    }
  })
}

export const remove = (ids) => {
  return request({
    url: '/springcloud-develop/datasource/remove',
    method: 'post',
    params: {
      ids
    }
  })
}

export const add = (row) => {
  return request({
    url: '/springcloud-develop/datasource/submit',
    method: 'post',
    data: row
  })
}

export const update = (row) => {
  return request({
    url: '/springcloud-develop/datasource/submit',
    method: 'post',
    data: row
  })
}

