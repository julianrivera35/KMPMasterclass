import SwiftUI
import Shared

struct ContentView: View {
    @State private var shouldOpenAbout = false
    
    var body: some View {
        let articleScreen = ArticlesScreen(viewModel: .init())
        NavigationStack{
            articleScreen
                .toolbar{
                    ToolbarItem{
                        Button{
                            shouldOpenAbout=true
                        } label: {
                            Label("About", systemImage:"info.circle").labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenAbout){
                            AboutScreen()
                        }
                    }
                }
        }.refreshable{
            articleScreen.viewModel.articlesViewModel.getArticles(forceFetch: true)
        }
    }
}


