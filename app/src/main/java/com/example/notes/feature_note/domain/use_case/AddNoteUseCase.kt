package com.example.notes.feature_note.domain.use_case

import com.example.notes.feature_note.domain.model.InvalidNoteException
import com.example.notes.feature_note.domain.model.Note
import com.example.notes.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) throw InvalidNoteException("Empty Title!!")
        if (note.content.isBlank()) throw InvalidNoteException("Empty Content!!")
        repository.insertNote(note)
    }
}