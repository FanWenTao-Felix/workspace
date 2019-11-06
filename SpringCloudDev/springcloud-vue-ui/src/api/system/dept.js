import request from '@/utils/request'

export const getList = (current, size, params) => {
  return request({
    url: '/api/springcloud-system/dept/list',
    method: 'get',
    params: {
      ...params,
      current,
      size
    }
  })
}
export const remove = (ids) => {
  return request({
    url: '/api/springcloud-system/dept/remove',
    method: 'post',
    params: {
      ids
    }
  })
}

export const add = (row) => {
  return request({
    url: '/api/springcloud-system/dept/submit',
    method: 'post',
    data: row
  })
}

export const update = (row) => {
  return request({
    url: '/api/springcloud-system/dept/submit',
    method: 'post',
    data: row
  })
}

export const getDept = (id) => {
  return request({
    url: '/api/springcloud-system/dept/detail',
    method: 'get',
    params: {
      id
    }
  })
}
export const getDeptTree = (tenantId) => {
  return request({
    url: '/api/springcloud-system/dept/tree',
    method: 'get',
    params: {
      tenantId
    }
  })
}

