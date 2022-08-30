package kr.loner.hoomasjip

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.loner.hoomasjip.sample.ui.SampleActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**TODO: 구조 예제 설명용 FakeActvitiy로 이동하는 임시 코드 입니다. 추후 삭제 예정. */
        startActivity(Intent(this, SampleActivity::class.java))
    }
}