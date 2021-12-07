package com.egovn.polygon

import com.egovn.base.json.objstore.ObjStore

/**
 * Created By dz on 2021-11-12.
 */
interface PolygonSystem {
    val config: PolygonConfig?
    val objStore: ObjStore?

    fun start()
    fun stop()

    companion object {
        @JvmStatic
        val I: PolygonSystem = PolygonSystemImpl()
    }
}