package com.packt.ch07.error_handling;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;

public class Demo_RxJava2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		
//		RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
//
//			@Override
//			public void accept(Throwable throwable) throws Exception {
//				// TODO Auto-generated method stub
//				System.out.println("from the handler"+throwable.getMessage());				
//			}
//		});
//		
//		RxJavaPlugins.setErrorHandler(e->{});

		Observable<Integer> observable = Observable.just(12, 30, 5, 50, 89);
		observable.filter(item -> {
			try {
				return check(item);
			} catch (IOException e) {
				// TODO: handle exception
				throw new NullPointerException(e.getMessage());
			}
		}).subscribe(new Observer<Integer>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("sequence completed");

			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
//				throwable.printStackTrace();
				RxJavaPlugins.onError(throwable);
			}

			@Override
			public void onNext(Integer value) {
				// TODO Auto-generated method stub
				System.out.println("got:-" + value);

			}

			@Override
			public void onSubscribe(Disposable disposable) {
				// TODO Auto-generated method stub

			}
		});

		
		}

	public static boolean check(int item) throws IOException {
		boolean result = false;
		if (item > 10)
			result = true;
		else
			throw new NullPointerException("***got an exception****");
		return result;

	}

}
