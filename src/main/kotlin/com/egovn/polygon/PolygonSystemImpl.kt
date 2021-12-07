package com.egovn.polygon

import com.egovn.base.json.objstore.LocalObjStore
import com.egovn.base.json.objstore.ObjStore

/**
 * Created By dz on 2021-11-14.
 */
class PolygonSystemImpl : PolygonSystem {
    override val objStore: ObjStore
    override val config: PolygonConfig

    init {
        objStore = LocalObjStore("d:/data/polygon/objs")
        config = objStore.retrieveAsObj("config.json", PolygonConfig::class.java)
    }

    override fun start() {}
    override fun stop() {}
}