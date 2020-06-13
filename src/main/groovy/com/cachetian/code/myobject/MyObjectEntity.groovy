package com.cachetian.code.myobject

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'tb_my_object')
class MyObjectEntity extends MyObjectBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long myId

    @Column
    Integer myType

    @Column
    String myGroup

    @Column
    String myCode

    @Column
    String myName

    @Column
    String myValue

}