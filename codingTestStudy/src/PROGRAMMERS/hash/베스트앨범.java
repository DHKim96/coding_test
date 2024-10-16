package PROGRAMMERS.hash;

import java.util.*;

class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수 저장
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 장르별 곡 목록 저장 (각 곡은 {곡 인덱스, 재생 횟수} 배열로 저장)
        Map<String, List<int[]>> songsByGenre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 장르별 총 재생 횟수 누적
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            // 장르별 곡 목록 갱신
            songsByGenre.putIfAbsent(genre, new ArrayList<>());
            songsByGenre.get(genre).add(new int[] {i, play});
        }

        // 장르를 총 재생 횟수로 내림차순 정렬
        List<String> genreOrder = new ArrayList<>(genrePlayCount.keySet());
        genreOrder.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        // 최종 베스트 앨범 리스트 생성
        List<Integer> bestAlbum = new ArrayList<>();

        for (String genre : genreOrder) {
            List<int[]> songs = songsByGenre.get(genre);

            // 장르 내에서 곡들을 재생 횟수 내림차순, 고유 번호 오름차순으로 정렬
            songs.sort((a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });

            // 상위 두 곡을 베스트 앨범에 추가
            bestAlbum.add(songs.get(0)[0]);
            if (songs.size() > 1) {
                bestAlbum.add(songs.get(1)[0]);
            }
        }

        // 리스트를 배열로 변환하여 반환
        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }
}
