package com.sub.cleanbooking.data

interface CountService {
    fun getCount(): Int
    fun saveCount(count: Int)
}

class CountServiceImpl: CountService {
    private var _count = 0

    override fun getCount() = _count

    override fun saveCount(count: Int) {
        _count = count
    }
}