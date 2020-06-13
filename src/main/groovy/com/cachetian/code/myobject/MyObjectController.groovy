package com.cachetian.code.myobject

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('my_object')
class MyObjectController {

    @Autowired
    MyObjectService service

    @GetMapping("")
    List<MyObjectDto> getMyObjects() {
        return service.getMyObjects()
    }

    @GetMapping("/{id}")
    def getMyObjectById(@PathVariable("id") String id) {
        return service.getMyObjectById(Long.parseLong(id))
    }

    @PostMapping("")
    def createMyObjects(@RequestBody Map payload) {
        return service.createMyObject(new MyObjectDto(payload))?.myId
    }

    @PutMapping("/{id}")
    def updateMyObjects(@PathVariable("id") String id, @RequestBody Map payload) {
        service.updateMyObject(new MyObjectDto(payload).tap {
            myId = Long.parseLong(id)
        })
    }

    @DeleteMapping("/{id}")
    def deleteMyObjectById(@PathVariable("id") String id) {
        service.deleteMyObjectById(Long.parseLong(id))
    }

}
