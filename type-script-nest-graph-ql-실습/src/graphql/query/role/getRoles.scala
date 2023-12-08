query getRoles {
  getRoles {
    statusCode,
    message,
    statusCode,
    message,
    pagination {
      perPageSize,
      totalCount,
      totalPage,
      data {
        roleId,
        job,
        requirement,
      }
    }
  }
}