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
- Liskov Substitution Principle (LSP): Prinsip ini kurang relevan karena tidak ada hierarki warisan yang jelas pada kode yang diberikan. Namun, prinsip ini mengingatkan untuk memastikan bahwa subclass yang menggantikan superclass tidak merusak fungsionalitas yang ada.
- Interface Segregation Principle (ISP): ProductService menunjukkan contoh ISP dengan menyediakan antarmuka yang spesifik untuk kebutuhan yang berbeda tanpa memaksa kelas untuk mengimplementasikan metode yang tidak mereka gunakan.
- Dependency Inversion Principle (DIP): Prinsip ini diterapkan melalui penggunaan interface ProductRepository, yang mengurangi ketergantungan langsung antara ProductServiceImpl dan implementasi repositori konkret.

 #### Keuntungan Penerapan Prinsip SOLID

- Pemeliharaan dan Pengembangan Kode: Prinsip SOLID menurut saya sangat memudahkan saya dalam pemeliharaan dan pengembangan kode dalam suatu proyek. Contohnya, dengan OCP, saya dapat menambahkan repositori baru untuk Product tanpa mengubah kode layanan yang ada.
- Fleksibilitas: Prinsip SOLID juga dapat meningkatkan fleksibilitas dan kemudahan dalam pengujian (test). DIP memudahkan penggantian komponen, seperti mengganti implementasi repositori saat pengujian dengan menggunakan mock objects.
- Kemudahan dalam Skalabilitas: SRP memastikan kelas memiliki satu alasan atau satu tujuan untuk berubah sehingga memudahkan penyesuaian atau penambahan fungsionalitas baru.

#### Kerugian Tidak Menerapkan Prinsip SOLID

- Kode Menjadi Sulit untuk Dikelola: Tanpa SRP, kelas dapat memiliki banyak tujuan untuk berubah sehingga dapat membuat kode menjadi rumit dan sulit untuk dikelola. Misalnya, jika ProductController juga mengelola logika akses data, perubahan pada persyaratan akses data memerlukan perubahan pada controller.
- Rendahnya Fleksibilitas: Tidak menerapkan DIP membuat kode sangat bergantung pada implementasi spesifik sehingga sulit untuk mengubah atau mengganti komponen tanpa mengubah banyak bagian dari kode. Sebagai contoh, mengganti database atau strategi persistensi membutuhkan perubahan luas pada kode.
- Kesulitan dalam Pengujian: Tanpa ISP dan DIP, unit test menjadi lebih sulit karena kelas mungkin bergantung pada detail implementasi yang tidak relevan dengan yang ingin diuji sehingga memaksa penggunaan penggantian yang kompleks atau infrastruktur pengujian yang berat.
