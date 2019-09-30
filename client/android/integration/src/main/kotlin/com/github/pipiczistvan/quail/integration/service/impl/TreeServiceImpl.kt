package com.github.pipiczistvan.quail.integration.service.impl

import com.github.pipiczistvan.quail.integration.domain.Tree
import com.github.pipiczistvan.quail.integration.service.TreeService
import com.github.pipiczistvan.quail.persistence.database.dao.TreeDao
import com.github.pipiczistvan.quail.persistence.database.entity.TreeEntity

internal class TreeServiceImpl(private val treeDao: TreeDao) : TreeService {
    override fun findAll(): List<Tree> = treeDao.all.map { entity -> Tree(entity.id) }
    override fun insertAll(trees: List<Tree>) = treeDao.insertAll(trees.map { tree -> TreeEntity(tree.id) })
}
