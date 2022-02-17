package kg.bakai.juice.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kg.bakai.juice.databinding.ActivityMainBinding
import kg.bakai.juice.domain.model.Coffee
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindView()
        observeUiState()
    }

    private fun bindView() {
        binding.apply {
            btnCalculate.setOnClickListener {
                val coffee = Coffee(
                    isSoyMilkAdded = cbMilk.isChecked,
                    isColumbia = cbBeans.isChecked,
                    isHot = cbHot.isChecked,
                    isCaramelAdded = cbCaramel.isChecked,
                    isAlmondAdded = cbAlmond.isChecked,
                    isMintAdded = cbMint.isChecked,
                    isSugarAdded = cbSugar.isChecked,
                    isDrawAdded = cbDraw.isChecked
                )
                viewModel.calculateSum(coffee = coffee)
            }
        }
    }

    private fun observeUiState() {
        binding.apply {
            lifecycleScope.launchWhenStarted {
                viewModel.state.collectLatest { state ->
                    when {
                        state.isLoading -> {
                            layoutSum.visibility = View.GONE
                            progressCircular.visibility = View.VISIBLE
                        }
                        state.error.isNotBlank() -> {
                            progressCircular.visibility = View.GONE
                            Snackbar.make(binding.root, state.error, Snackbar.LENGTH_LONG).show()
                        }
                        else -> {
                            progressCircular.visibility = View.GONE
                            layoutSum.visibility = View.VISIBLE
                            tvSum.text = "\$${state.sum}"
                        }
                    }
                }
            }
        }
    }


}