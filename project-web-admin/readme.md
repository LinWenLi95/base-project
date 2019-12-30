### controller/service/dao中通用方法/接口的实现：
* mapper继承mybatis plus的通用mapper
* service继承自定义的通用BaseService
* serviceImpl中BaseService部分的方法通过继承自定义的通用BaseServiceImpl来实现
* controller中常用的API接口通过继承自定义的通用BaseController来提供
