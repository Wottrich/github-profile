package wottrich.github.io.githubprofile.ui.profile

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import github.io.wottrich.ui.GithubApplicationTheme
import github.io.wottrich.ui.components.SearchComponent
import github.io.wottrich.ui.components.SearchState
import github.io.wottrich.ui.values.backgroundColor
import org.koin.androidx.viewmodel.ext.android.viewModel
import wottrich.github.io.githubprofile.R
import wottrich.github.io.githubprofile.archive.showAlert
import wottrich.github.io.githubprofile.ui.profile.screen.ProfileScreen
import wottrich.github.io.githubprofile.ui.repository.RepositoryActivity

@ExperimentalFoundationApi
class ProfileActivity : AppCompatActivity() {

    private val viewModel: ProfileViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubApplicationTheme {
                var textFieldValue by remember { mutableStateOf(TextFieldValue()) }
                var searchState by remember { mutableStateOf(SearchState.InitialState) }
                Scaffold(
                    topBar = {
                        SearchComponent(
                            onValueChange = { textFieldValue = it },
                            onSearch = { viewModel.loadServices(textFieldValue.text) },
                            onSearchStateChanged = { searchState = it },
                            searchState = searchState,
                            textFieldValue = textFieldValue
                        )
                    },
                    backgroundColor = backgroundColor
                ) {
                    ProfileScreen(
                        viewModel = viewModel,
                        onRepositoryClick = {
                            RepositoryActivity.launch(
                                this,
                                profileLogin = it.owner.login,
                                repositoryName = it.name
                            )
                        }
                    )
                }
            }
        }

        setupObserves()
    }

    private fun setupObserves() {
        val activity = this
        viewModel.apply {

            error.observe(activity) {
                showAlert(
                    getString(R.string.dialog_default_error_title),
                    if (it == null) getString(R.string.unknown_error)
                    else getString(it)
                ) {
                    setNeutralButton("OK", null)
                }
            }
        }
    }

}