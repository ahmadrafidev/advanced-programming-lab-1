## Refleksi menggunakan Spring Boot pada Tutorial 1
Selama pengembangan dua fitur baru dalam aplikasi Spring Boot saya, saya berusaha menerapkan berbagai prinsip clean code dan secure coding yang telah saya pelajari. Berikut ini adalah beberapa poin penting terkait penerapan yang saya pakai:

## Clean Code:
- Konsistensi Penamaan: Saya menggunakan konvensi penamaan yang konsisten untuk metode, variabel, class, dan interface yang membuat kode lebih mudah dibaca dan dipahami.
- Metode Singkat dan Fokus: Setiap metode yang saya implementasikan fokus pada satu fungsi sehingga dapat memudahkan pengujian dan pemeliharaan untuk pengembangan ke depannya.
- Penggunaan Komentar yang Sederhana: Saya berusaha meminimalisir penggunaan komentar dengan membuat kode yang self-explanatory, akan tetapi pada kode yang menurut saya agak kompleks saya tetap menyertakan komentar untuk memudahkan pemahaman.


## Praktik Secure Coding:
- Validasi Input: Saya menambahkan validasi untuk input yang diterima dari pengguna, baik di lapisan controller maupun service untuk mencegah injeksi data yang tidak diinginkan dari sisi klien.
- Pengelolaan Exception dengan Defensive Programming: Saya mengimplementasikan penanganan exception yang cukup ketat supaya setiap handle dapat mengelola potensi error.

## Area Perbaikan:
Setelah evaluasi, saya menyadari beberapa area yang memerlukan perbaikan:

- Implementasi Penggunaan ID: Saya perlu mengoptimalkan penggunaan ID pada setiap product yang dibuat supaya aplikasi lebih robust ketika digunakan oleh pengguna.


# Kesimpulan
Proses implementasi Tutorial 1 ini  sangat berharga bagi saya dalam hal pengembangan perangkat lunak. Saya belajar banyak mengenai pentingnya menulis kode yang tidak hanya berfungsi tetapi juga bersih, mudah dipahami, dan aman. 