package com.cachetian.code.myobject

class MyObjectBase {
    Map asMap() {
        Map map = [:]
        for (item in this.class.declaredFields) {
            if (!item.synthetic) {
                map << [(item.name): this."$item.name"]
            }
        }
        return map
    }
}
