package com.cachetian.code.myobject

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MyObjectService {

    @Autowired
    MyObjectDao dao

    List<MyObjectDto> getMyObjects() {
        return dao.findAll().collect {
            return new MyObjectDto(it.asMap())
        }
    }

    MyObjectDto getMyObjectById(Long myId) {
        return new MyObjectDto(dao.getOne(myId).asMap())
    }

    Long createMyObject(MyObjectDto vo) {
        return new MyObjectDto(dao.save(new MyObjectEntity(vo.asMap())).asMap())?.myId
    }

    void updateMyObject(MyObjectDto vo) {
        dao.save(dao.getOne(vo.myId).tap {
            myCode = vo.myCode
            myGroup = vo.myGroup
            myName = vo.myName
            myType = vo.myType
            myValue = vo.myValue
        })
    }

    void deleteMyObjectById(Long myId){
        dao.delete(dao.getOne(myId))
    }
}
