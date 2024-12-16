package com.itheima.test.ex2_opp;

// 操作类
public class MovieOperator {
    private Movie[] movies;

    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }

    // 1.展示系统全部电影信息
    public void printAllMovies() {
        System.out.println("-----All Movies:-----");
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            System.out.println(m.getName() + "'s price is " + m.getPrice());
        }
    }

    // 2. 根据id查询该电影的详细信息
    public void searchMovieById(String id) {
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            if (m.getId().equals(id)) {
                System.out.println(m.getName() + "'s price is " + m.getPrice());
                return;
            }
        }
        System.out.println("Movie not found");
    }
}
