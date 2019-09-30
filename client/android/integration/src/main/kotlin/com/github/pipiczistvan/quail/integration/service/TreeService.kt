package com.github.pipiczistvan.quail.integration.service

import com.github.pipiczistvan.quail.integration.domain.Tree

interface TreeService {
    fun findAll(): List<Tree>
    fun insertAll(trees: List<Tree>)
}
