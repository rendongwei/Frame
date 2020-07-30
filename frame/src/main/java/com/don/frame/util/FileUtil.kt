package com.don.frame.util

import java.io.*


object FileUtil {

    // 创建文件目录
    fun createDirFile(filePath: String?): File? {
        if (filePath.isNullOrEmpty()) {
            return null
        }
        var dirFile = File(filePath)
        if (!dirFile.exists()) {
            if (dirFile.mkdirs()) {
                return dirFile
            }
        }
        return null
    }

    // 创建文件
    fun createNewFile(filePath: String?): File? {
        if (filePath.isNullOrEmpty()) {
            return null
        }
        var file = File(filePath)
        var parentFile = file.parentFile
        if (!parentFile.exists()) {
            createDirFile(parentFile.path)
        }
        if (!file.exists()) {
            if (file.createNewFile()) {
                return file
            }
        }
        return null
    }

    // 文件夹是否存在
    fun isFolderExist(filePath: String?): Boolean {
        if (filePath.isNullOrEmpty()) {
            return false
        }
        var dirFile = File(filePath)
        return dirFile.exists() && dirFile.isDirectory
    }

    // 文件是否存在
    fun isFileExist(filePath: String?): Boolean {
        if (filePath.isNullOrEmpty()) {
            return false
        }
        var file = File(filePath)
        return file.exists() && file.isFile
    }

    // 删除文件
    fun deleteFile(filePath: String?): Boolean {
        if (filePath.isNullOrEmpty()) {
            return false
        }
        var file = File(filePath)
        if (!file.exists()) {
            return true
        }
        if (file.isFile) {
            return file.delete()
        }
        if (file.isDirectory) {
            return file.deleteRecursively()
        }
        return false
    }

    // 获取文件大小
    // READ_EXTERNAL_STORAGE
    fun getFileSize(filePath: String?): Long {
        if (filePath.isNullOrEmpty()) {
            return 0L
        }
        var file = File(filePath)
        if (file.exists()) {
            return file.length()
        }
        return 0L
    }

    // 获取文件夹大小
    // READ_EXTERNAL_STORAGE
    fun getFolderSize(filePath: String?): Long {
        if (filePath.isNullOrEmpty()) {
            return 0L
        }
        var file = File(filePath)
        if (!file.isDirectory) {
            return getFileSize(filePath)
        }
        var size = 0L
        try {
            file.listFiles().forEach {
                size += if (it.isDirectory) {
                    getFolderSize(it.path)
                } else {
                    it.length()
                }
            }
            return size
        } catch (e: Exception) {
        }
        return 0L
    }

    // 读取文件
    fun readFile(filePath: String?, charset: String = "UTF-8"): String? {
        if (filePath.isNullOrEmpty()) {
            return null
        }
        var file = File(filePath)
        if (!file.exists() || !file.isFile) {
            return null
        }
        var stringBuffer = StringBuffer()
        var bufferReader: BufferedReader? = null
        try {
            var inputStreamReader = InputStreamReader(FileInputStream(file), charset)
            bufferReader = BufferedReader(inputStreamReader)
            var line: String? = bufferReader.readLine()
            while (line != null) {
                if (stringBuffer.isNotEmpty()) {
                    stringBuffer.append("\r\n")
                }
                stringBuffer.append(line)
                line = bufferReader.readLine()
            }
            bufferReader.close()
            inputStreamReader.close()
            return stringBuffer.toString()
        } catch (e: Exception) {
        } finally {
            bufferReader?.close()
        }
        return null
    }

    // 写入文件
    fun writeFile(content: String?, filePath: String?, isAppend: Boolean = false): Boolean {
        if (content.isNullOrEmpty() || filePath.isNullOrEmpty()) {
            return false
        }
        var file = File(filePath)
        if (!file.exists()) {
            createNewFile(filePath)
        }
        var fileWriter: FileWriter? = null
        try {
            fileWriter = FileWriter(file, isAppend)
            fileWriter.write(content)
            fileWriter.close()
            return true
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            fileWriter?.close()
        }
        return false
    }
}