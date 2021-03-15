package com.mumumusuc.filament.framework

interface FilaEvent {

}

data class FilaWindowEvent(val width: Int, val height: Int) : FilaEvent {

}

data class FilaKeyEvent(val key: Int) : FilaEvent {

}

data class FilaMouseEvent(val key: Int) : FilaEvent {

}
