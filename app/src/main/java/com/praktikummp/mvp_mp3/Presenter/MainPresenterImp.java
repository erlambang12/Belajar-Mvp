package com.praktikummp.mvp_mp3.Presenter;

public class MainPresenterImp implements MainPresenter {

    MainView mainView;

    public MainPresenterImp(MainView mainView) { this.mainView = mainView;}

    @Override
    public void hitungLuas(Double alas, Double tinggi) {
        Double luas = alas*tinggi;
        mainView.updateTextHasilLuas(luas);
    }

    @Override
    public void hitungKeliling(Double panjang, Double lebar) {
        Double keliling = 2*(panjang+lebar);
        mainView.updateTextHasilKeliling(keliling);
    }
}
