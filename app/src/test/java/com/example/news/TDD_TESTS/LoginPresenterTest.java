package com.example.news.TDD_TESTS;

import com.example.news.Models.Login.LogInTestInterface;
import com.example.news.Presenters.LogInActivityPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)

public class LoginPresenterTest {

    LogInActivityPresenter logInActivityPresenter;

    @Mock
    LogInTestInterface logInTestInterface;


    @Before
    public  void setUp(){
        logInActivityPresenter = new LogInActivityPresenter(logInTestInterface);
    }

    @Test
    public void checkIfLoginAttemptIsExceeded() {
    logInActivityPresenter.checkFromData("" , "123456789");
    Mockito.verify(logInTestInterface).showErrorMessage();
    }



}
/*
 Task<AuthResult> auth = mock(Task.class);
        when(mockFirebaseAuth.createUserWithEmailAndPassword("ahmed@gmail.com","123456789")).thenReturn(auth);
        auth.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println(e.toString());
            }
        });
 */