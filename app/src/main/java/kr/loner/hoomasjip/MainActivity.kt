package kr.loner.hoomasjip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kr.loner.hoomasjip.sample.ui.SampleActivity
import kr.loner.hoomasjip.sooyeolsample.presentation.ui.SooyeolActivity

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**TODO: 구조 예제 설명용 FakeActvitiy로 이동하는 임시 코드 입니다. 추후 삭제 예정. */
        findViewById<Button>(R.id.loner).setOnClickListener {
            startActivity(Intent(this, SampleActivity::class.java))
        }
        findViewById<Button>(R.id.jeayoung).setOnClickListener {
            startActivity(Intent(this, SampleActivity::class.java))
        }
        findViewById<Button>(R.id.sooyeol).setOnClickListener {
            startActivity(SooyeolActivity.newIntent(this))
        }
    }
}