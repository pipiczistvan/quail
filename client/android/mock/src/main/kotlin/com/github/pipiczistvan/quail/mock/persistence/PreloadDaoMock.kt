package com.github.pipiczistvan.quail.mock.persistence

import androidx.sqlite.db.SupportSQLiteQuery
import com.github.pipiczistvan.quail.persistence.database.dao.PreloadDao
import com.github.pipiczistvan.quail.persistence.database.entity.PreloadEntity

class PreloadDaoMock : PreloadDao() {

    private var entity: PreloadEntity? = null

    override fun get(query: SupportSQLiteQuery): PreloadEntity? {
        return entity
    }

    override fun save(entity: PreloadEntity) {
        this.entity = entity
    }
}