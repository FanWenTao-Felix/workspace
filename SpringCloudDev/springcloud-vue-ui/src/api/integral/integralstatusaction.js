import request from '@/utils/request'

export const getList = (current, size, params) => {
  return request({
    url: '/springcloud-integral/integralstatusaction/list',
    method: 'get',
    params: {
      ...params,
      current,
      size,
      descs: 'id'
    }
  })
}

export const getDetail = (id) => {
  return request({
    url: '/springcloud-integral/integralstatusaction/detail',
    method: 'get',
    params: {
      id
    }
  })
}

export const remove = (ids) => {
  return request({
    url: '/springcloud-integral/integralstatusaction/remove',
    method: 'post',
    params: {
      ids
    }
  })
}

export const add = (row) => {
  return request({
    url: '/springcloud-integral/integralstatusaction/submit',
    method: 'post',
    data: row
  })
}

export const update = (row) => {
  return request({
    url: '/springcloud-integral/integralstatusaction/submit',
    method: 'post',
    data: row
  })
}

export const selectOption = (row) => {
  return request({
    url: '/springcloud-integral/integralstatusaction/select',
    method: 'get',
    data: row
  })
}

