package com.bahaa.quizapp;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuizListViewModel extends ViewModel implements FirebaseRepository.OnFirestoreTaskComplete {

    private MutableLiveData<List<QuizListModel>> quizMutableLiveData = new MutableLiveData<>();

    public LiveData<List<QuizListModel>> getQuizMutableLiveData() {
        return quizMutableLiveData;
    }

    private FirebaseRepository firebaseRepository = new FirebaseRepository(this);

    public QuizListViewModel() {
        firebaseRepository.getQuizData();
    }

    @Override
    public void quizListDataAdded(List<QuizListModel> quizListModelList) {
        quizMutableLiveData.setValue(quizListModelList);
    }

    @Override
    public void onError(Exception e) {

    }
}
