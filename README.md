# Refleksi Mingguan Advanced Programming

## Refleksi Module 1
Selama pengembangan fitur  dalam aplikasi Spring Boot ini, saya berusaha menerapkan berbagai prinsip clean code dan secure coding yang telah saya pelajari. Berikut ini adalah beberapa poin penting terkait penerapan yang saya pakai:

#### Clean Code:
- Konsistensi Penamaan: Saya menggunakan konvensi penamaan yang konsisten untuk metode, variabel, class, dan interface yang membuat kode lebih mudah dibaca dan dipahami.
- Metode Singkat dan Fokus: Setiap metode yang saya implementasikan fokus pada satu fungsi sehingga dapat memudahkan pengujian dan pemeliharaan untuk pengembangan ke depannya.
- Penggunaan Komentar yang Sederhana: Saya berusaha meminimalisir penggunaan komentar dengan membuat kode yang self-explanatory, akan tetapi pada kode yang menurut saya agak kompleks saya tetap menyertakan komentar untuk memudahkan pemahaman.


#### Praktik Secure Coding:
- Validasi Input: Saya menambahkan validasi untuk input yang diterima dari pengguna, baik di lapisan controller maupun service untuk mencegah injeksi data yang tidak diinginkan dari sisi klien.
- Pengelolaan Exception dengan Defensive Programming: Saya mengimplementasikan penanganan exception yang cukup ketat supaya setiap handle dapat mengelola potensi error.

#### Area Perbaikan:
Setelah evaluasi, saya menyadari beberapa area yang memerlukan perbaikan:

- Implementasi Penggunaan ID: Saya perlu mengoptimalkan penggunaan ID pada setiap product yang dibuat supaya aplikasi lebih robust ketika digunakan oleh pengguna.


#### Kesimpulan
Proses implementasi Tutorial 1 ini  sangat berharga bagi saya dalam hal pengembangan perangkat lunak. Saya belajar banyak mengenai pentingnya menulis kode yang tidak hanya berfungsi tetapi juga bersih, mudah dipahami, dan aman. 

## Refleksi Module 2

## Refleksi Module 3

#### Penerapan Prinsip SOLID

- Single Responsibility Principle (SRP): Setiap kelas memiliki satu tanggung jawab. Contohnya, ProductController hanya mengelola permintaan HTTP, ProductService mengelola logika bisnis, dan ProductRepository bertanggung jawab atas akses data.
- Open/Closed Principle (OCP): Kelas dibuat terbuka untuk ekstensi tapi tertutup untuk modifikasi. Implementasi interface ProductRepository memungkinkan penggantian atau penambahan fungsionalitas tanpa mengubah kode yang ada.
- Interface Segregation Principle (ISP): ProductService menunjukkan contoh ISP dengan menyediakan antarmuka yang spesifik untuk kebutuhan yang berbeda tanpa memaksa kelas untuk mengimplementasikan metode yang tidak mereka gunakan.
- Dependency Inversion Principle (DIP): Prinsip ini diterapkan melalui penggunaan interface ProductRepository, yang mengurangi ketergantungan langsung antara ProductServiceImpl dan implementasi repositori konkret.

 #### Keuntungan Penerapan Prinsip SOLID

- Kemudahan Pemeliharaan dan Pengembangan Kode: Prinsip SOLID menurut saya sangat memudahkan saya dalam pemeliharaan dan pengembangan kode dalam suatu proyek. Contohnya, dengan OCP, saya dapat menambahkan repositori baru untuk Product/Car tanpa mengubah kode layanan yang ada. Kemudian, dengan SRP saya bisa memastikan bahwa setiap kelas hanya memiliki satu fokus saja.
- Fleksibilitas: Prinsip SOLID juga dapat meningkatkan fleksibilitas dan kemudahan dalam pengujian (test). Prinsip DIP dapat meningkatkan fleksibilitas dan memudahkan pengujian dengan mengurangi ketergantungan langsung antara komponen-komponen high-level dan low-level. Contohnya, CarService bergantung pada abstraksi (CarRepository interface), bukan implementasi spesifik. Hal ini memungkinkan mudahnya penggantian CarRepository dengan mock saat pengujian, tanpa perlu mengubah CarService.
- Kemudahan dalam Skalabilitas: SRP memastikan kelas memiliki satu alasan atau satu tujuan untuk berubah sehingga memudahkan penyesuaian atau penambahan fungsionalitas baru. Kemudian, prinsip OCP memudahkan penambahan fitur baru tanpa mengubah kode yang sudah ada. Contohnya, jika ada kebutuhan untuk menambahkan fitur baru, seperti pencarian mobil berdasarkan fitur tertentu, kita dapat menambahkan metode baru pada interface CarService tanpa mengubah implementasi yang sudah ada, memungkinkan sistem untuk tumbuh tanpa merusak fungsi yang sudah ada.
- Kemudahan Mengelola Dependensi (ISP): ISP memungkinkan pemisahan fungsi ke dalam interface yang lebih spesifik sehingga kelas hanya bergantung pada fungsi yang mereka butuhkan. Cara ini memudahkan pengelolaan dependensi dan membuat kode lebih modular. Pada kasus Car ini menunjukkan kebutuhan untuk ISP pada CarService sudah cukup fokus.

#### Kerugian Tidak Menerapkan Prinsip SOLID

- Kode Sulit Dikelola: Tanpa SRP, CarService yang juga menangani logika UI atau database membuat kode kompleks. Setiap perubahan memerlukan revisi pada CarService, menambah beban pemeliharaan.
- Rendahnya Fleksibilitas: Tanpa DIP, mengganti CarRepository dengan implementasi baru (misal, dari database lokal ke cloud) menjadi sulit karena CarServiceImpl terikat kuat pada implementasi spesifik.
- Kesulitan Pengujian: Tanpa ISP dan DIP, unit testing CarServiceImpl menjadi kompleks karena harus menangani banyak dependensi yang tidak relevan, mempersulit isolasi dan pengujian fungsi spesifik.

## Refleksi Module 4

1. Refleksi Berdasarkan Pertanyaan Reflektif Percival (2017):
Selama mengikuti step-by-step tutorial, menurut saya Test-Driven Development (TDD) merupakan metode yang sangat berharga dalam pengembangan perangkat lunak. Saya menemukan bahwa alur TDD cukup berguna bagi saya. Dengan menggunakan TDD, saya dapat memastikan bahwa kode yang saya tulis memiliki tujuan yang jelas dan terverifikasi, yang mana bisa meningkatkan kualitas serta keandalan dari software yang saat ini sedang dikembangkan. Namun, saya juga menyadari bahwa ada ruang kesempatan untuk perbaikan dalam pembuatan test supaya test yang dibuat lebih robust, seperti perlu mengalokasikan waktu lebih untuk merencanakan dan memahami uji kasus yang lebih beragam, sehingga bisa menutup lebih banyak skenario pengujian. 

2. Refleksi Berdasarkan Prinsip F.I.R.S.T:
Setelah menciptakan unit tes dalam tutorial, saya berpendapat bahwa tes yang saya (sesuai dengan tutorial) buat belum sepenuhnya mengikuti prinsip F.I.R.S.T. (Fast, Independent, Repeatable, Self-Validating, Timely). Beberapa tes mungkin tidak berjalan secepat yang seharusnya karena adanya kompleksitas yang diperiksa dalam beberapa service java atau mungkin ada tes yang tidak sepenuhnya independen dan bisa dipengaruhi oleh tes lain. Kemudian, untuk mengatasi ini, saya perlu memastikan bahwa tes yang saya buat di masa depan harus lebih cepat dalam eksekusi, tidak bergantung pada tes lain, dapat diulang dalam kondisi apa pun, dan memberikan validasi otomatis tanpa adanya intervensi manual. Cara-cara ini menurut saya akan memastikan bahwa kelengkapan unit tes menjadi lebih robust dan dapat diandalkan untuk pengembangan aplikasi nantinya.
